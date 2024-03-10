package com.tobeto.bootcamp.core.crossCuttingConcerns.logging;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.lang.annotation.Documented;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "log_details")
public class LogDetail {
    @Id
    private String id;
    // mongodb de idler kendine ozgu veriliyo

    @Field("method_name")
    public String methodName;
    //log kayıtlar demek uygulamada yapılanı tutmak kayıt incelemek içim method adı tutuyoruz

   @Field("user")
    private String user;
   //kim hareketi yapmıs gorelim diye

    private List<LogParameter> logParameters;

}
