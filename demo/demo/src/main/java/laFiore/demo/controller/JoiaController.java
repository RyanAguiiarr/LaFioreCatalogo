package laFiore.demo.controller;

import jakarta.validation.Valid;
import laFiore.demo.Dto.JoiaRequestDto;
import laFiore.demo.Dto.JoiaResponseDto;
import laFiore.demo.service.JoiaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/joias")
@AllArgsConstructor
public class JoiaController {

    private final JoiaService joiaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<JoiaResponseDto> cadastrarJoia(@RequestBody @Valid JoiaRequestDto req) throws Exception{
        JoiaResponseDto novaJoia = joiaService.cadastrarJoia(req);

        return ResponseEntity.status(HttpStatus.CREATED).body(novaJoia);
    }

}
