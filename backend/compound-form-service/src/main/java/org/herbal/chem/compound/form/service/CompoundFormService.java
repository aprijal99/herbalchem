package org.herbal.chem.compound.form.service;

public interface CompoundFormService {
    Integer sendCompoundServiceDtoToKafka(byte[] compoundServiceDto);
}
