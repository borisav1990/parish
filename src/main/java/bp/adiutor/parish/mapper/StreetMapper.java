package bp.adiutor.parish.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import bp.adiutor.parish.dto.StreetDTO;
import bp.adiutor.parish.model.Street;

@Mapper(componentModel = "spring")
public interface StreetMapper {

   @Mapping(source = "city.cityId", target = "city")
   StreetDTO entityToApi(Street street);
   
   @Mapping(source = "city", target = "city.cityId")
   Street apiToEntity(StreetDTO streetDTO);
}
