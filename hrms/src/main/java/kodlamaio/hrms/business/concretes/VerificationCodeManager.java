package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.results.ErrorDataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.GenerateRandomCode;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	VerificationCodeDao verificationCodeDao;
	UserDao userDao;

	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao, UserDao userDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
		//this.userDao = userDao;
	}

	 @Override
		public void generateCode(VerificationCode code,Integer id) {

					code.setCode(null);
					code.setVerified(false);
					if(code.isVerified() == false) {
						GenerateRandomCode generator = new GenerateRandomCode();
						String code_create = generator.create();
						code.setCode(code_create);
						code.setId(id);
				
						verificationCodeDao.save(code);
						
					}
					return ;
		}
		
		@Override
		public Result verify(String verificationCode,Integer id) {

			VerificationCode ref = verificationCodeDao.findById(id).stream().findFirst().get();
			if(ref.getCode().equals(verificationCode) && ref.isVerified() != true) {
				ref.setVerified(true);
				return  new SuccessDataResult<VerificationCode>(this.verificationCodeDao.save(ref),"Başarılı");
			}
			else if(ref.isVerified() == true) {
				return  new ErrorDataResult<VerificationCode>(null,"Zaten Doğrulanmış Hesap");
			}
			return  new ErrorDataResult<VerificationCode>(null,"Doğrulama Kodu Geçersiz");
			
		}
}
