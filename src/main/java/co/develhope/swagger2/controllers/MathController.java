package co.develhope.swagger2.controllers;

import co.develhope.swagger2.entities.ArithmeticOperation;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/math")
public class MathController {

    @GetMapping
    @ApiOperation(value = "Says Welcome", notes = "Prints the welcome message for the user")
    public String welcomeMathMsg() {
        return "Welcome to math";
    }

    @GetMapping("/division-info")
    @ApiOperation(value = "Says the division info", notes = "Prints the information of the division for the user")
    public ArithmeticOperation getDivisionInfo() {
        return new ArithmeticOperation("Division", 2, "takes the two numbers and return the division of them", new String[]{"Anti-commutative", "Anti-associative"});
    }

    @GetMapping("/multiplication")
    @ApiOperation(value = "Multiplicates two numbers", notes = "Prints the multiplication of the two numbers for the user")
    public Integer getMultiplication(@RequestParam(required = false)Integer n1, @RequestParam(required = false)Integer n2) {
        return n1 * n2;
    }

    @GetMapping("/square/{n}")
    @ApiOperation(value = "Calculate the square", notes = "Prints the square of the parameter for the user")
    public Integer getSquare(@PathVariable(required = false) Integer n) {
        return n*n;
    }

}