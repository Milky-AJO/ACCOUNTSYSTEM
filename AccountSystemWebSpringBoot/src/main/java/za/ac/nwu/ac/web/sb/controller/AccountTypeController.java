package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import springfox.documentation.service.Tags;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionsFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountTypeController
{
    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;
    private final FetchAccountTransactionsFlow fetchAccountTransactionsFlow;

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow, @Qualifier("createAccountTypeFlowName") CreateAccountTypeFlow createAccountTypeFlow, FetchAccountTransactionsFlow fetchAccountTransactionsFlow)
    {
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
        this.fetchAccountTransactionsFlow = fetchAccountTransactionsFlow;
    }


    @GetMapping("/all-type")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Return list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll()
    {
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/new-type")
    @ApiOperation(value = "Creates a new AccountType.", notes = "Creates a new Accounttype in the database.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountType was created succesfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
            @ApiParam(value = "Request body to create a new AccountType.", required = true)
            @RequestBody AccountTypeDto accountType)
    {
        AccountTypeDto accountTypeResponse = createAccountTypeFlow.create(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all-transaction")
    @ApiOperation(value = "Gets all the Account transactions.", notes = "Return list of account transactions.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAllTransactions()
    {
        List<AccountTransactionDto> accountTransactions = fetchAccountTransactionsFlow.getAllTransactions();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse(true, accountTransactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update-transaction+200/{accountTrxMember}")
    @ApiOperation(value = "Updates a transaction to add 200.", notes = "Updates a transaction in the database.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> setTransactionAmount(
            @ApiParam(value = "The ID of the member",
            example = "1",
            name = "accountTrxMember",
            required = true)
            @PathVariable("accountTrxMember") final Long accountTrxMember)
    {
        AccountTransactionDto accountTransaction = fetchAccountTransactionsFlow.setTransactionAmount(accountTrxMember);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransaction);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update-transaction-200/{accountTrxMemberMin}")
    @ApiOperation(value = "Updates a transaction to subtract 200.", notes = "Updates a transaction in the database.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> setTransactionAmountMin(
            @ApiParam(value = "The ID of the member",
                    example = "1",
                    name = "accountTrxMemberMin",
                    required = true)
            @PathVariable("accountTrxMemberMin") final Long accountTrxMemberMin)
    {
        AccountTransactionDto accountTransaction = fetchAccountTransactionsFlow.setTransactionAmountMin(accountTrxMemberMin);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransaction);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update-transaction-type/{accountTransId}")
    @ApiOperation(value = "Updates a transaction type.", notes = "Updates a transaction type in the database.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> setTransactionType(
            @ApiParam(value = "The ID of the transaction",
                    example = "1",
                    name = "accountTransId",
                    required = true)
            @PathVariable("accountTransId") final Long accountTransId)
    {
        AccountTransactionDto accountTransaction = fetchAccountTransactionsFlow.setTransactionType(accountTransId);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransaction);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update-type-Dollar/{accountTypeId}")
    @ApiOperation(value = "Updates a type to Dollar.", notes = "Updates type in the database.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> setAccountTypeToDollar(
            @ApiParam(value = "The ID of the account type",
                    example = "1",
                    name = "accountTypeId",
                    required = true)
            @PathVariable("accountTypeId") final Long accountTypeId)
    {
        AccountTypeDto accountType = fetchAccountTypeFlow.setAccountTypeToDollar(accountTypeId);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

 //setAccountTypeToDollar(Long accountTypeId)

}