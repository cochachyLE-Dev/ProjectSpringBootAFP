package pe.com.bootcamp.entities.converters;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		if(attribute == null){
            return null;
        }

        return Date.valueOf(attribute);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		if(dbData == null){
            return null;
        }

        return dbData.toLocalDate();
	}

}
