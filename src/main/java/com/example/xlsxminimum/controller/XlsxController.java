package com.example.xlsxminimum.controller;

import com.example.xlsxminimum.service.XlsxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/xlsx")
public class XlsxController {

    private final XlsxService xlsxService;

    public XlsxController(XlsxService xlsxService) {
        this.xlsxService = xlsxService;
    }

    @GetMapping("/kmin")
    public ResponseEntity<Integer> getKthMin(
            @RequestParam String filePath,
            @RequestParam int N) throws Exception {
        return ResponseEntity.ok(xlsxService.findKthMinimum(filePath, N));
    }
}
