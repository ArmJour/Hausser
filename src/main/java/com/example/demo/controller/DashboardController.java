package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Dummy data untuk Tawaran Kerja
        List<Map<String, Object>> tawaranKerja = new ArrayList<>();
        
        Map<String, Object> tawaran1 = new HashMap<>();
        tawaran1.put("nama", "Bu Siti Aminah");
        tawaran1.put("gaji", "Rp 5.000.000");
        tawaran1.put("lokasi", "Jl. Ananas No. 12, Malang");
        tawaran1.put("preferensi", "Bisa memasak");
        tawaranKerja.add(tawaran1);
        
        Map<String, Object> tawaran2 = new HashMap<>();
        tawaran2.put("nama", "Bu Ratna Sari");
        tawaran2.put("gaji", "Rp 4.500.000");
        tawaran2.put("lokasi", "Jl. Veteran No. 5, Malang");
        tawaran2.put("preferensi", "Bisa memasak");
        tawaranKerja.add(tawaran2);
        
        Map<String, Object> tawaran3 = new HashMap<>();
        tawaran3.put("nama", "Pak Budi Santoso");
        tawaran3.put("gaji", "Rp 6.000.000");
        tawaran3.put("lokasi", "Jl. Raya Tlogomas, Malang");
        tawaran3.put("preferensi", "Bisa merawat lansia");
        tawaranKerja.add(tawaran3);
        
        // Dummy data untuk Negosiasi
        List<Map<String, Object>> negosiasi = new ArrayList<>();
        
        Map<String, Object> nego1 = new HashMap<>();
        nego1.put("nama", "Bu Dewi Lestari");
        nego1.put("update", "2 hours ago");
        negosiasi.add(nego1);
        
        Map<String, Object> nego2 = new HashMap<>();
        nego2.put("nama", "Pak Ahmad Yani");
        nego2.put("update", "3 hours ago");
        negosiasi.add(nego2);
        
        Map<String, Object> nego3 = new HashMap<>();
        nego3.put("nama", "Bu Kartini Wijaya");
        nego3.put("update", "5 hours ago");
        negosiasi.add(nego3);
        
        Map<String, Object> nego4 = new HashMap<>();
        nego4.put("nama", "Pak Hendra Gunawan");
        nego4.put("update", "7 hours ago");
        negosiasi.add(nego4);
        
        model.addAttribute("tawaranKerja", tawaranKerja);
        model.addAttribute("negosiasi", negosiasi);
        model.addAttribute("userName", "Ahmad"); // Nama user yang login
        
        return "dashboard-view";
    }
}