package kg.itacademy.demo.service;

import kg.itacademy.demo.entity.EventPhoto;
import kg.itacademy.demo.model.CreateEventPhotoModel;
import kg.itacademy.demo.repository.EventPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventPhotoServiceImpl implements EventPhotoService{
    @Autowired
    private EventPhotoRepository eventPhotoRepository;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private EventService eventService;


    @Override
    public EventPhoto save(EventPhoto eventPhoto) {
        return eventPhotoRepository.save(eventPhoto);
    }

    @Override
    public EventPhoto save(CreateEventPhotoModel eventPhotoModel) {
        EventPhoto eventPhoto = EventPhoto.builder()
                .photo(photoService.findById(eventPhotoModel.getPhotoId()))
                .event(eventService.findById(eventPhotoModel.getEventId()))
                .build();
        return eventPhotoRepository.save(eventPhoto);
    }

    @Override
    public EventPhoto findById(Long id) {
        return eventPhotoRepository.findById(id).orElse(null);// Вернуть исключение
    }

    @Override
    public EventPhoto deleteById(Long id) {
        EventPhoto eventPhoto = findById(id);
        if (eventPhoto != null) {
            eventPhotoRepository.delete(eventPhoto);
            return eventPhoto;
        }
        return null;// Вернуть исключение
    }

    @Override
    public List<EventPhoto> getAllEventPhoto(Long id) {
        return eventPhotoRepository.findAllByEvent_Id(id);
    }
}
