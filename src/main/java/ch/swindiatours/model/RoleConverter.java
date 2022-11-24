package ch.swindiatours.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Converter for enumerator of roles, storing the name to database instead of a value.
 *
 * @author chant
 * @version 1.0
 */
@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role attribute) {
        return Role.getRoleName(attribute.name());
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        return Role.getRole(dbData);
    }
}
