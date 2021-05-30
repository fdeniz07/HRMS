package kodlamaio.hrms.core.utilities;

import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessResult;

public class BusinessEngine {

    public static Result run(Result... logics) {
        for (Result logic : logics) {
            if (!logic.isSuccess()){
                return logic;
            }
        }
        return new SuccessResult();
    }
}
