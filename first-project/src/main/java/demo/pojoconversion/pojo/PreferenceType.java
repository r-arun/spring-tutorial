package demo.pojoconversion.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PreferenceType {
    RUP("RUP"),
    MerchantPreferences("MerchantPreferences"),
    NONE(null);
 
     private final String preferenceType;
}
