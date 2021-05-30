package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorDataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.core.utilities.BusinessEngine;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserService userService;
	private VerificationCodeService verificationCodeService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService,
			VerificationCodeService verificationCodeService) {
		super();
		this.employerDao = employerDao;
		this.userService = userService;
		this.verificationCodeService = verificationCodeService;

	}

	@Override
	public DataResult<List<Employer>> findAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),
				"Is verenler basarili bir sekilde listelendi");
	}

	@Override
	public DataResult<Employer> add(Employer employer) {

		Result engine = BusinessEngine.run(companyNameValidator(employer), webSiteValidator(employer),
				passwordNullValidator(employer), isRealEmployer(employer), isRealPhoneNumber(employer),
				isEmailAlreadyRegistered(employer));
		if (!engine.isSuccess()) {
			return new ErrorDataResult<Employer>(null, engine.getMessage());
		}
		User savedUser = this.userService.add(employer);
		this.verificationCodeService.generateCode(new VerificationCode(), savedUser.getId());
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),
				"İş Veren Hesabı Eklendi, Doğrulama Kodu Gönderildi ID:" + employer.getId());
	}

	private Result companyNameValidator(Employer employer) {
		if (employer.getCompanyName().isBlank() || employer.getCompanyName() == null) {
			return new ErrorResult("Lütfen firma isminizi bos gecmeyiniz");
		}
		return new SuccessResult();
	}

	private Result webSiteValidator(Employer employer) {
		if (employer.getWebAddress().isBlank() || employer.getWebAddress() == null) {
			return new ErrorResult("Lütfen web adresinizi bos gecmeyiniz");
		}
		return new SuccessResult();
	}

	private Result isRealEmployer(Employer employer) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(employer.getEmail());
		if (!matcher.matches()) {
			return new ErrorResult("Geçersiz Email Adresi");
		} else if (!employer.getEmail().contains(employer.getWebAddress())) {
			System.out.println(employer.getEmail() + " " + employer.getWebAddress());
			return new ErrorResult("Domain adresi girmek zorundasınız");
		}
		return new SuccessResult();

	}

	private Result isEmailAlreadyRegistered(Employer employer) {
		if (employerDao.findAllByEmail(employer.getEmail()).stream().count() != 0) {
			return new ErrorResult("Email zaten kayıtlı");
		}
		return new SuccessResult();
	}

	private Result passwordNullValidator(Employer employer) {
		if (employer.getPassword().isBlank() || employer.getPassword() == null) {
			return new ErrorResult("Şifre Bilgisi Doldurulmak zorundadır");
		}
		return new SuccessResult();
	}

	private Result isRealPhoneNumber(Employer employer) {
		String patterns = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
		/*
		 * ÖRNEK TELEFON NUMARALARI String[] validPhoneNumbers =
		 * {"2055550125","202 555 0125", "(202) 555-0125", "+111 (202) 555-0125",
		 * "636 856 789", "+111 636 856 789", "636 85 67 89", "+111 636 85 67 89"};
		 */
		Pattern pattern = Pattern.compile(patterns);
		Matcher matcher = pattern.matcher(employer.getPhoneNumber());
		if (!matcher.matches()) {
			return new ErrorResult("Geçersiz Telefon Numarası");
		}
		return new SuccessResult();

	}
}
