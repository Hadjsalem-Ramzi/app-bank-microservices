package net.hadjsalem.accountservice.mapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.hadjsalem.accountservice.dtos.BankAccountDto;
import net.hadjsalem.accountservice.entities.BankAccount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor

public class BankAccountMapper {

    @Autowired
   private  ModelMapper mapper;


    public BankAccountDto from(BankAccount bankAccount){
       return mapper.map(bankAccount,BankAccountDto.class);
   }

   public BankAccount from(BankAccountDto bankAccountDto){
       return  mapper.map(bankAccountDto,BankAccount.class);
   }


}
