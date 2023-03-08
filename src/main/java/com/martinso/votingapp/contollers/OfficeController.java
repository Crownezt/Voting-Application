package com.martinso.votingapp.contollers;

import com.martinso.votingapp.office.dto.request.OfficeRequest;
import com.martinso.votingapp.office.dto.response.OfficeResponse;
import com.martinso.votingapp.office.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/office")
public class OfficeController {

    private final OfficeService service;

    @Autowired
    public OfficeController(OfficeService service) {
        this.service = service;
    }

    @PostMapping("/create")
     public ResponseEntity<?> register(@RequestBody OfficeRequest request){
        OfficeResponse response = service.createOffice(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("{officeId}")
    public void delete(@PathVariable Long officeId){
       service.deleteOffice(officeId);
    }
}
