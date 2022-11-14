package fr.esgi.cleancode.persistence;

import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;
import io.vavr.control.Either;

public interface PersistenceSpi<T, ID> {
	Either<InvalidDriverSocialSecurityNumberException, T> save(T o);
}