package com.user.User_Management.controller;

import com.user.User_Management.dto.ReqRes;
import com.user.User_Management.entity.OurUsers;
import com.user.User_Management.service.UsersManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserManagementController {
    @Autowired
    private UsersManagementService usersManagementService;

    @PostMapping("/auth/register")
    public ResponseEntity<ReqRes> register(@RequestBody ReqRes reqRes) {
        return ResponseEntity.ok(usersManagementService.register(reqRes));
    }
    @PostMapping("/auth/login")
    public ResponseEntity<ReqRes> login(@RequestBody ReqRes req) {
        return ResponseEntity.ok(usersManagementService.login(req));
    }
    @PostMapping("/auth/refresh")
    public ResponseEntity<ReqRes> refresh(@RequestBody ReqRes req) {
        return ResponseEntity.ok(usersManagementService.refreshToken(req));
    }
    @GetMapping("/admin/get-all-users")
    public ResponseEntity<ReqRes> getAllUsers() {
        return ResponseEntity.ok(usersManagementService.getAllUsers());
    }
    @GetMapping("/admin/get-users/{userId}")
    public ResponseEntity<ReqRes> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(usersManagementService.getUsersById(userId));

    }
    @PutMapping("/admin/update/{userId}")
    public ResponseEntity<ReqRes> updateUser(@PathVariable Long userId, @RequestBody OurUsers ourUsers) {
        return ResponseEntity.ok(usersManagementService.updateUser(userId,ourUsers));
    }
    @GetMapping("/admin/get-profile")
    public ResponseEntity<ReqRes> getMyProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        ReqRes response = usersManagementService.getMyInfo(email);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @DeleteMapping("/admin/delete/{userId}")
    public ResponseEntity<ReqRes> deleteUser(@PathVariable Long userId) {
        return ResponseEntity.ok(usersManagementService.deleteUser(userId));
    }

}
