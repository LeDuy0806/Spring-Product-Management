package com.overpower.ProductManagementApi.controller;

import com.overpower.ProductManagementApi.models.AffiliateStat;
import com.overpower.ProductManagementApi.models.Transaction;
import com.overpower.ProductManagementApi.models.User;
import com.overpower.ProductManagementApi.repository.AffiliateStatRepository;
import com.overpower.ProductManagementApi.repository.TransactionRepository;
import com.overpower.ProductManagementApi.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/management")
public class ManagementController {
    private final UserService userService;
    @Autowired
    private final AffiliateStatRepository affiliateStatRepository;
    @Autowired
    private final TransactionRepository transactionRepository;
    public ManagementController(UserService userService, AffiliateStatRepository affiliateStatRepository, TransactionRepository transactionRepository) {
        this.userService = userService;
        this.affiliateStatRepository = affiliateStatRepository;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/admins")
    public List<User> getAdmins(){
        List<String> roles = Arrays.asList("admin", "superadmin");
        return userService.getUserByRole(roles);
    }
    @GetMapping("/performance/{id}")
    public ResponseEntity<Map<String, Object>> getUserPerformance(@PathVariable("id") String id) {
            User user = userService.getUserById(id);

            Optional<AffiliateStat> affiliateStats = affiliateStatRepository.findByUserId(new ObjectId(id));




            if (!affiliateStats.isPresent()) {
                return ResponseEntity.badRequest().body(Collections.emptyMap());
            }

            List<String> affiliateSales = affiliateStats.get().getAffiliateSales();
            List<Transaction> saleTransactions = transactionRepository.findByIdIn(affiliateSales);

            saleTransactions.removeIf(Objects::isNull);

            Map<String, Object> response = new HashMap<>();
            response.put("user", user);
            response.put("sales", saleTransactions);

            return ResponseEntity.ok().body(response);

    }
}

