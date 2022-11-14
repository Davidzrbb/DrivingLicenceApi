package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.exception.ApplicationError;
import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;
import fr.esgi.cleancode.model.DrivingLicence;
import fr.esgi.cleancode.persistence.DrivingLicenceCreatorApi;
import fr.esgi.cleancode.persistence.DrivingLicencePersistenceSpi;
import fr.esgi.cleancode.service.validator.SocialSecurityNumberValidator;
import io.vavr.control.Either;
import io.vavr.control.Validation;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class DrivingLicenceSaveService implements DrivingLicenceCreatorApi {

	private final InMemoryDatabase database;
	private final DrivingLicenceIdGenerationService drivingLicenceIdGenerationService;
	private final DrivingLicencePersistenceSpi drivingLicencePersistenceSpi;

	public Either<InvalidDriverSocialSecurityNumberException, DrivingLicence> create(String socialSecurityNumber) {

		Validation<InvalidDriverSocialSecurityNumberException, String> socialSecurityNumberValidator = SocialSecurityNumberValidator.validate(socialSecurityNumber);
		DrivingLicence drivingLicence = DrivingLicence.builder()
				.id(drivingLicenceIdGenerationService.generateNewDrivingLicenceId())
				.driverSocialSecurityNumber(socialSecurityNumber)
				.build();

		return socialSecurityNumberValidator.toEither().mapLeft(socialSecurityNumberValidator)

	}
}
