package org.herbal.chem.authorization.mapper;

import org.herbal.chem.authorization.entity.UserAccountDto;
import org.herbal.chem.authorization.entity.UserAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface UserAccountMapper {
    UserAccountEntity dtoToEntity(UserAccountDto userAccountDto);
    UserAccountDto entityToDto(UserAccountEntity userAccountEntity);
    void updateStoredEntity(UserAccountDto userAccountDto, @MappingTarget UserAccountEntity userAccountEntity);
}
