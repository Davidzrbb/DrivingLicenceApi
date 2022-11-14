package fr.esgi.cleancode.persistence;

import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;
import fr.esgi.cleancode.model.DrivingLicence;
import io.vavr.control.Either;

public interface DrivingLicenceCreatorApi<T, ID> {
	Either<InvalidDriverSocialSecurityNumberException, DrivingLicence> create(String socialSecurityNumber);
}
