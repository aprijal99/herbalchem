package org.herbal.chem.authorization.service;

import org.herbal.chem.authorization.entity.UserAccountDto;
import org.herbal.chem.authorization.entity.UserAccountEntity;

public interface UserAccountService {
    void saveUserAccount(UserAccountEntity userAccountEntity);
    UserAccountEntity findUserAccount(String username);
    void updateUserAccount(UserAccountDto userAccountDto, String username);
}
