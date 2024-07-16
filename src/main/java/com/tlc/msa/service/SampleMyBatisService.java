package com.tlc.msa.service;

import com.tlc.msa.dto.SampleDto;
import com.tlc.msa.mapper.SampleMapper;
import com.tlc.msa.response.ResponseObject;
import com.tlc.msa.vo.SampleVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SampleMyBatisService {
    private final SampleMapper sampleMapper;

    
    public ResponseObject post(SampleVo vo) {
        SampleDto sampleDto = SampleDto.builder()
                .id(vo.getId())
                .content(vo.getContent())
                .post(vo.getPost())
                .build();

        sampleMapper.insert(sampleDto);

        ResponseObject responseObject = new ResponseObject();
        responseObject.putResult(true);
        return responseObject;
    }

    
    public ResponseObject get() {
        List<SampleDto> selectAll = sampleMapper.selectAll();

        ResponseObject responseObject = new ResponseObject();
        responseObject.putResult(selectAll);
        return responseObject;
    }

    
    public ResponseObject delete(String id) {
        int selectAll = sampleMapper.delete(id);

        ResponseObject responseObject = new ResponseObject();
        responseObject.putResult(selectAll);
        return responseObject;
    }
}