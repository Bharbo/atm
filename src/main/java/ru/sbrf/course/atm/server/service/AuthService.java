package ru.sbrf.course.atm.server.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbrf.course.atm.server.support.Response;

@Service
@Getter
public class AuthService {

    StartService startService;

    @Autowired
    public AuthService(StartService startService) {
        this.startService = startService;
    }

    public Response checkPass(String atmPass) {
        if (atmPass.equals(startService.getCurrentCard().getPass())) {
            return new Response(true, "\nВыберите операцию\n");
        } else {
            return new Response(false, "\nВы ввели некорректный пароль, попробуйте снова\n");
        }
    }
}
