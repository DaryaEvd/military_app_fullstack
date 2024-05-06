//package ccfit.nsu.ru.daryaevd.military_unit.controller;
//
//import ccfit.nsu.ru.daryaevd.military_unit.dto.CommanderDto;
//import ccfit.nsu.ru.daryaevd.military_unit.service.CommanderService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@AllArgsConstructor
//@RestController
//@RequestMapping("/api/commanders")
//public class CommanderController {
//    private CommanderService commanderService;
//
//    // add commander
//    @PostMapping
//    public ResponseEntity<CommanderDto> createCommander(@RequestBody CommanderDto commanderDto){
//        CommanderDto savedCommander = commanderService.createCommander(commanderDto);
//        return new ResponseEntity<>(savedCommander, HttpStatus.CREATED);
//    }
//
//    // get commander
//    @GetMapping("{id}")
//    public ResponseEntity<CommanderDto> getCommanderById(@PathVariable("id") Long commanderId) {
//        CommanderDto commanderDto = commanderService.getCommanderById(commanderId);
//        return ResponseEntity.ok(commanderDto);
//    }
//
//    // get all commanders
//    @GetMapping
//    public ResponseEntity<List<CommanderDto>> getAllCommanders() {
//        List<CommanderDto> commanders = commanderService.getAllCommanders();
//        return ResponseEntity.ok(commanders);
//    }
//
//    // update commander info
//    @PutMapping("{id}")
//    public ResponseEntity<CommanderDto> updateCommander(@PathVariable("id") Long commanderId,
//                                                        @RequestBody CommanderDto updatedCommander) {
//        CommanderDto commanderDto = commanderService.updateCommander(commanderId, updatedCommander);
//        return ResponseEntity.ok(commanderDto);
//    }
//
//    // delete commander
//    @DeleteMapping("{id}")
//    public ResponseEntity<String> deleteCommander(@PathVariable("id") Long commanderId) {
//        commanderService.deleteCommander(commanderId);
//        return ResponseEntity.ok("Commander deleted successfully");
//    }
//}
