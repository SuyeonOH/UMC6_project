package umc.mission7.validation.validator;

import org.springframework.beans.factory.annotation.Autowired;
import umc.mission7.repository.MissionRepository;
import umc.mission7.validation.annotation.ExistMission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MissionExistValidator implements ConstraintValidator<ExistMission, Long> {

    @Autowired
    private MissionRepository missionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        return missionRepository.existsById(missionId);
    }
}
