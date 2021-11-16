package bp.adiutor.parish.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import bp.adiutor.parish.model.Church;
import bp.adiutor.parish.model.Eparchy;




@DataJpaTest
public class EparchyRepositoryTest {

    @Autowired
    EparchyRepository eparchyRepository;
    
    @Autowired
    ChurchRepository churchRepository;
    
    
    @Test
    public void createObject() {
    	Date date = new Date();
    	Eparchy e = new Eparchy();
    	e.setEparchyId(1); 
    	e.setName("Шабачка");
    	e.setCreatedAt(date);
    	e.setUpdatedAt(date);
    	e.setChurches(null);
    	}
}
