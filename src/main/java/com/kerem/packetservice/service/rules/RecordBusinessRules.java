package com.kerem.packetservice.service.rules;

import com.kerem.packetservice.common.constants.Messages;
import com.kerem.packetservice.core.exceptions.BusinessException;
import com.kerem.packetservice.repository.RecordRepository;
import lombok.AllArgsConstructor;
import org.apache.tika.Tika;
import org.springframework.stereotype.Service;

import java.util.Base64;
@Service
@AllArgsConstructor
public class RecordBusinessRules {
    private final RecordRepository repository;
    private final Tika tika;
    public void checkIfRecordexists(int id){
        if ((!repository.existsById(id))) throw new BusinessException(Messages.Record.NotExists);
    }



    public void isFileContentTypeSupported(String base64code){
        tika.setMaxStringLength(-1);
        String mimeType = tika.detect(Base64.getDecoder().decode(base64code));
        System.out.println(mimeType);
        if (!(mimeType.equals("audio/mpeg"))) throw new BusinessException(Messages.Record.NotSupportedContentType);
    }
}
