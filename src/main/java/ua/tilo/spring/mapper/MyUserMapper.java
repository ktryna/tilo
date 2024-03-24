package ua.tilo.spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ua.tilo.spring.dto.MyUserDTO;
import ua.tilo.spring.model.MyUser;

@Mapper
public interface MyUserMapper {
    MyUserMapper INSTANCE = Mappers.getMapper(MyUserMapper.class);


    MyUser toStudent(MyUserDTO myUserDTO);

}

