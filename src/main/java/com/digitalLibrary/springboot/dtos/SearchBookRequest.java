package com.digitalLibrary.springboot.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SearchBookRequest {
    @NotBlank
    private String searchKey;
    @NotBlank
    private String searchValue;
    @NotBlank
    private String operator;

    private static Set<String> allowedKeys=new HashSet<>();
    private static HashMap<String,List<String>> allowedOperator=new HashMap<String, List<String>>();
    SearchBookRequest()
    {
        allowedKeys.addAll(Arrays.asList("name","author_name","genre","pages","id"));
        allowedOperator.put("name",Arrays.asList("=","like"));
        allowedOperator.put("author_name",Arrays.asList("=","<","<=",">=",">"));
        allowedOperator.put("pages",Arrays.asList("=","<","<=",">=",">"));
        allowedOperator.put("genre",Arrays.asList("="));
        allowedOperator.put("id",Arrays.asList("="));
    }

    public boolean validate() {
        if(!allowedKeys.contains(searchKey)) {
            return false;
        }
        List<String> validOperators =allowedOperator.get(this.searchKey);
        if(!validOperators.contains(this.operator)) {
            return false;
        }
        return true;
    }
}
