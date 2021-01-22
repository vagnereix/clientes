package io.github.vagnereix.clientes.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigDecimalConverter {

    public BigDecimal converter(String value){
        if(value == null){
            return null;
        }

        //1.000,00 -> 1000.00
        value = value.replace(".", "") //1.000,00 -> 1000,00
                .replace(",", "."); //1000,00 -> 1000.00

        return new BigDecimal(value);
    }

}
