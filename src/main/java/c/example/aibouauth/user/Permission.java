package c.example.aibouauth.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {


    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),

    ADMIN_CREATE("admin::create"),

    ADMIN_DELETE("admin:delete"),

    ADMIN_MODIFY_MONTANT("admin:modify_montant"),


    MANAGER_READ("  MANAGER:read"),
    MANAGER_UPDATE("  MANAGER:update"),

    MANAGER_CREATE("  MANAGER::create"),

    MANAGER_DELETE("  MANAGER:delete")
    ;

@Getter
    private  final  String permission;
}
