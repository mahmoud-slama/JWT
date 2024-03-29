package c.example.aibouauth.user;


import c.example.aibouauth.purchase.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UsersService service;

//    @PatchMapping
//    public ResponseEntity<?> changePassword(
//       @RequestBody changePasswordRequest request,
//       Principal connectedUser
//    ){
//        service.changePassword(request,connectedUser);
//        return  ResponseEntity.ok().build();
//    }

    @PutMapping("/user/maxAmount/{id}")
    public ResponseEntity<UserDto> updateMaxAmount(@RequestBody UserDto updatedUserData, @PathVariable Integer id) {
        return Optional.ofNullable(service.getUserById(id))
                .map(existingUser -> {
                    service.updateMaxAmount(updatedUserData, id);
                    return ResponseEntity.ok(UserDto.fromEntity(existingUser));
                })
                .orElse(ResponseEntity.notFound().build());
    }




    @GetMapping("/user/maxAmount/{id}")
    public ResponseEntity<Double> getMaxAmount(@PathVariable Integer id) {
        Optional<User> userOptional = Optional.ofNullable(service.getUserById(id));

        return userOptional.map(user -> ResponseEntity.ok(user.getMaxAmount()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/montant/{id}")
    public ResponseEntity<BigDecimal> getMontant(@PathVariable Integer id) {
        Optional<User> userOptional = Optional.ofNullable(service.getUserById(id));

        return userOptional.map(user -> ResponseEntity.ok(user.getMontant()))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/verification")
    public ResponseEntity<?> verifyAccount(@RequestParam String email, @RequestParam String code) {
        service.verifyAccount(email, code);
        return ResponseEntity.ok().build();
    }



}
