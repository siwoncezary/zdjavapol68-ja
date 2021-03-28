package solution.task14.controller;

import solution.task14.abook.model.AddressItem;
import solution.task14.exceptions.*;

/**
 * Interfejs dostarczający metod do odczytu danych w aplikacji
 * Można zdefiniować różne klasy odczytujące te dane np. z kanału komunikatora sieciowego
 */
public interface InputDataController {
    AddressItem inputAddressItem() throws AddressItemInvalidNameException, AddressItemInvalidEmailException, AddressItemInvalidPhoneNumberException, AddressItemInvalidBirthDateException, AddressItemInvalidFullNameException;
    int inputDeletingAddressNumber();
    String inputName();
    String inputPhone();
}
