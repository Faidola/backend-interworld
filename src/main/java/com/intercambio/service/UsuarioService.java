package com.intercambio.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.intercambio.dto.UsuarioDTO;
import com.intercambio.entity.Usuario;
import com.intercambio.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> findById(Integer id) {
		return usuarioRepository.findById(id);
	}

	public Optional<Usuario> findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	public Usuario save(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDTO.getNome());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setDataCadastro(LocalDateTime.now());
		usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
		usuario.setNivelAcesso(usuarioDTO.getNivelAcesso() != null ? usuarioDTO.getNivelAcesso() : "USER");
		usuario.setStatusUsuario("ATIVO");
		return usuarioRepository.save(usuario);
	}

	@Transactional
	public Usuario saveEstudante(UsuarioDTO usuarioDTO) {

		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDTO.getNome());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setDataCadastro(LocalDateTime.now());
		usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
		usuario.setNivelAcesso("INTERCAMBISTA");
		usuario.setStatusUsuario("ATIVO");

		return usuarioRepository.save(usuario);

	}

	@Transactional
	public Usuario saveEscola(UsuarioDTO usuarioDTO) {

		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDTO.getNome());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setDataCadastro(LocalDateTime.now());
		usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
		usuario.setNivelAcesso("ESCOLA");
		usuario.setStatusUsuario("ATIVO");

		return usuarioRepository.save(usuario);

	}

	public Usuario update(Integer id, UsuarioDTO usuarioDTO) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
		if (optionalUsuario.isPresent()) {
			Usuario usuario = optionalUsuario.get();
			usuario.setNome(usuarioDTO.getNome());
			usuario.setEmail(usuarioDTO.getEmail());
			if (usuarioDTO.getSenha() != null && !usuarioDTO.getSenha().isEmpty()) {
				usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
			}
			if (usuarioDTO.getNivelAcesso() != null) {
				usuario.setNivelAcesso(usuarioDTO.getNivelAcesso());
			}
			if (usuarioDTO.getStatusUsuario() != null) {
				usuario.setStatusUsuario(usuarioDTO.getStatusUsuario());
			}
			return usuarioRepository.save(usuario);
		}
		return null;
	}

	public boolean delete(Integer id) {
		if (usuarioRepository.existsById(id)) {
			usuarioRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public boolean existsByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}

	public Usuario mudarStatus(Integer id) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
		if (optionalUsuario.isPresent()) {
			Usuario usuario = optionalUsuario.get();
			if (usuario.getStatusUsuario().equals("ATIVO")) {
				usuario.setStatusUsuario("INATIVO");
			} else {
				usuario.setStatusUsuario("ATIVO");
			}
			
			return usuarioRepository.save(usuario);
		}
		return null;
	}
}