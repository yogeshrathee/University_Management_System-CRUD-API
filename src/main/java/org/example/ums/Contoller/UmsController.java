package org.example.ums.Contoller;

import org.example.ums.Model.Ums;
import org.example.ums.Services.UmsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ums")
public class UmsController {


    UmsService umsService;
    public UmsController(UmsService umsService){
        this.umsService=umsService;
    }

    @GetMapping("{regNo}")
    public Ums getById(@PathVariable("regNo") int regNo){
       return umsService.getById(regNo);

    }

    @GetMapping
        public List<Ums> getAll(){
        return umsService.getAll();

    }

    @PostMapping
    public String createDetails(@RequestBody Ums ums){
        umsService.createDetails(ums);
        return "Created Successfully ";
    }

    @PutMapping
    public String updateDetails(@RequestBody Ums ums){
        umsService.updateDetails(ums);
        return "Updated Successfully";
    }

    @DeleteMapping("{regNo}")
    public String deleteById(@PathVariable("regNo") int regNo){
        umsService.deleteById(regNo);
        return "deleted by id Successfully";

    }

    @DeleteMapping
    public List<Ums> deleteAll(){
        return umsService.deleteAll();

    }
}
