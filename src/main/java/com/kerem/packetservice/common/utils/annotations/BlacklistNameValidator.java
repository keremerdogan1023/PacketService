package com.kerem.packetservice.common.utils.annotations;

import com.kerem.packetservice.common.constants.Messages;
import com.kerem.packetservice.core.exceptions.BusinessException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlacklistNameValidator implements ConstraintValidator<BlacklistName,String> {

    private static final String  filePath = "C:\\turkcellbootcamp\\PacketService\\blacklist.txt";
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        List<String> listOfStrings = new ArrayList<String>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                listOfStrings.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return !(listOfStrings.contains(name));



    }
}
