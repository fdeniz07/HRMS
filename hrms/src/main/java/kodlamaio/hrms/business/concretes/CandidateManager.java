package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.constants.CallbackMessages;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorDataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.core.utilities.BusinessEngine;
import kodlamaio.hrms.core.validations.IdentificationNumberValidator;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private VerificationCodeService verificationCodeService;
	private UserService userService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, VerificationCodeService verificationCodeService,
			UserService userService) {
		super();
		this.candidateDao = candidateDao;
		this.verificationCodeService = verificationCodeService;
		this.userService = userService;
	}

	@Override
	public DataResult<List<Candidate>> findAll() {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), CallbackMessages.listedCandidates);
	}

	@Override
	public DataResult<Candidate> add(Candidate candidate) {

		Result engine = BusinessEngine.run(firstNameValidator(candidate), 
				lastNameValidator(candidate),
				IdentificationNumberValidator.isRealPerson(candidate.getIdentificationNumber()), 
				IdValidator(candidate),
				birthDateValidator(candidate), 
				emailNullValidator(candidate), 
				isRealEmail(candidate),
				passwordNullValidator(candidate), 
				isMailRegistered(candidate));
		
		if (!engine.isSuccess()) {
			return new ErrorDataResult(null, engine.getMessage());
		}

		User savedUser = this.userService.add(candidate);
		this.verificationCodeService.generateCode(new VerificationCode(), savedUser.getId());
		return new SuccessDataResult<Candidate>(this.candidateDao.save(candidate),
				CallbackMessages.isRegisterSuccessForCandidateMessage);

	}

	private Result firstNameValidator(Candidate candidate) {
		if (candidate.getFirstname().isBlank() || candidate.getFirstname().equals(null)) {
			return new ErrorResult(CallbackMessages.requiredFirstName);

		}
		return new SuccessResult();
	}

	private Result lastNameValidator(Candidate candidate) {
		if (candidate.getLastname().isBlank() || candidate.getLastname().equals(null)) {
			return new ErrorResult(CallbackMessages.requiredLastName);
		}
		return new SuccessResult();
	}

	private Result birthDateValidator(Candidate candidate) {
		if (candidate.getBirthDate().equals(null)) {
			return new ErrorResult(CallbackMessages.requiredBirthDate);
		}
		return new SuccessResult();
	}

	private Result emailNullValidator(Candidate candidate) {
		if (candidate.getEmail().isBlank() || candidate.getEmail().equals(null)) {
			return new ErrorResult(CallbackMessages.requiredEmail);
		}
		return new SuccessResult();
	}

	private Result passwordNullValidator(Candidate candidate) {
		if (candidate.getPassword().isBlank() || candidate.getPassword().equals(null)) {
			return new ErrorResult(CallbackMessages.requiredPassword);
		}
		return new SuccessResult();
	}

	private Result isRealEmail(Candidate candidate) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(candidate.getEmail());
		if (!matcher.matches()) {
			return new ErrorResult(CallbackMessages.isRealMail);
		}
		return new SuccessResult();

	}

	private Result IdValidator(Candidate candidate) {
		if (candidate.getIdentificationNumber().isBlank()) {
			return new ErrorResult(CallbackMessages.requiredId);
		}

		return new SuccessResult();
	}

	private Result isMailRegistered(Candidate candidate) {
		if (candidateDao.findAllByEmail(candidate.getEmail()).stream().count() != 0) {
			return new ErrorResult(CallbackMessages.alreadyRegisteredMail);
		}
		return new SuccessResult();
	}

	private Result isIdRegistered(Candidate candidate) {
		if (candidateDao.findAllByIdentificationNumber(candidate.getIdentificationNumber()).stream().count() != 0) {
			return new ErrorResult(CallbackMessages.alreadyRegisteredId);
		}
		return new SuccessResult();
	}

}
