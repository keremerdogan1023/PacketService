package com.kerem.packetservice.business.rules;

import com.kerem.packetservice.common.constants.Messages;
import com.kerem.packetservice.core.exceptions.BusinessException;
import com.kerem.packetservice.repository.AudiobookRepository;
import lombok.AllArgsConstructor;
import org.apache.tika.Tika;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
public class AudiobookBusinessRules {
    private final AudiobookRepository repository;
    private final Tika tika;
    private final static String  blackListPathFile = "C:\\turkcellbootcamp\\PacketService\\blacklist.txt";



    public void isFileContentTypeSupported(String base64code){
        tika.setMaxStringLength(-1);
        String mimeType = tika.detect(Base64.getDecoder().decode(base64code));
        System.out.println(mimeType);
        if (!(mimeType.equals("audio/mpeg"))) throw new BusinessException(Messages.Audiobook.NotSupportedContentType);
        }
}





    