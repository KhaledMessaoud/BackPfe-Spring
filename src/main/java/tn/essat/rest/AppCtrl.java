	package tn.essat.rest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.essat.dao.IArticle;
import tn.essat.dao.IMail;
import tn.essat.dao.IRole;
import tn.essat.dao.ITheme;
import tn.essat.dao.IUser;
import tn.essat.model.Article;
import tn.essat.model.Mail;
import tn.essat.model.Role;
import tn.essat.model.Theme;
import tn.essat.model.User;
import tn.essat.service.ArticleService;


@CrossOrigin("*")
@RestController
@RequestMapping(path = "/rest")
public class AppCtrl {
	@Autowired
	IUser dao_user;

	@Autowired
	IRole dao_role;

	@Autowired
	IArticle dao_article;

	@Autowired
	ITheme dao_theme;
	
	@Autowired
	IMail dao_mail;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/users")
	public List<User> fnu1() {
		return dao_user.findAll();
	}

	@GetMapping("/userById/{id}")
	public Optional<User> fnu2(@PathVariable("id") Integer id) {
		return dao_user.findById(id);
	}

	
	@GetMapping("/userByUsername/{username}")
	public User fnu3(@PathVariable("username") String username) {
		return dao_user.findByUsername(username);
	}
	
	@GetMapping("/userByEmail/{email}")
	public User fnu4(@PathVariable("email") String email) {
		return dao_user.findByEmail(email);
	}

	@PostMapping("/updateUser")
	public User fnu5(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return dao_user.save(user);
	}

	@GetMapping("/deleteUser/{id}")
	public void fnu6(@PathVariable("id") Integer id) {
		dao_user.deleteById(id);
	}
	
	/*@GetMapping("/userByRole/{role}")
	public List<User> fnu7(@PathVariable("role") String role){
		return dao_user.findByRole(role);
	}*/

	@GetMapping("/roles")
	public List<Role> fnr1() {
		return dao_role.findAll();
	}

	@GetMapping("/roleById/{id}")
	public Optional<Role> fnr2(@PathVariable("id") Integer id) {
		return dao_role.findById(id);
	}
	
	@GetMapping("/themes")
	public List<Theme> fnt1() {
		return dao_theme.findAll();
	}

	@GetMapping("/themeById/{id}")
	public Optional<Theme> fnt2(@PathVariable("id") Integer id) {
		return dao_theme.findById(id);
	}
	
	@PostMapping("/addTheme")
	public Theme fnt3(@RequestBody Theme theme) {
		return dao_theme.save(theme);
	}
	
	@DeleteMapping("/delthem/{id}")
	public void f3(@PathVariable("id") int id) {
		dao_theme.deleteById(id);
	}
	
	@GetMapping("/articles")
	public List<Article> fna1() {
		return articleService.getFileList();
	}

	@GetMapping("/articleById/{id}")
	public Article fna2(@PathVariable Integer id) {
		return articleService.getFileById(id);
	}
	
	@PostMapping("/upload")
	public Article uploadFile (@RequestParam("file") MultipartFile file) throws IOException {
		return articleService.store(file);
	}
	
	@GetMapping("/downloadFile/{id}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer id){
		Article article = articleService.getFileById(id);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(article.getType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+article.getName()+"\"")
				.body(new ByteArrayResource(article.getData()));
	}
	
	@PostMapping("/sendMail")
	public Mail fnm1(@RequestBody Mail m) {
		return dao_mail.save(m);
	}
	
	@GetMapping("/mailrecus/{id}")
	public List<Mail> fnm2(@PathVariable("id") int id) {
		return dao_mail.getAllMessagesRecusByIdUser(id);
	}

	@GetMapping("/mailsent/{id}")
	public List<Mail> fnm3(@PathVariable("id") int id) {
		return dao_mail.getAllMessagesSendByIdUser(id);
	}
	
	//@GetMapping("/articleByTheme/{id}")

}
