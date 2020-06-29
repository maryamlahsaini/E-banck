package ensa.com.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ensa.com.Repositary.AgentRepositary;
import ensa.com.entity.Agence;
import ensa.com.entity.Agent;
import ensa.com.entity.Compte;
import ensa.com.entity.Libelles;
import ensa.com.entity.Parameters;
import ensa.com.metier.AdminMetier;
import ensa.com.metier.AdminMetierImpl;
import ensa.com.metier.AgentMetier;
@CrossOrigin("*")
@WebService(name="MaBanque")
@Component
@RestController
public class AdminController {
	
	@Autowired
	private AdminMetier adminMetier;
	
	@Autowired
	private AgentMetier agentmetier;
	
	@WebMethod(operationName = "AgentByUserName")
    @RequestMapping(value="/Admin/agents/{username}",method=RequestMethod.GET)
	@PreAuthorize("hasRole('AGENT')")
	public Agent findByUsename(@PathVariable("username")@WebParam(name = "codeAgence")String username) {
		return agentmetier.findByUsename(username);
	}
	
	@WebMethod(operationName = "ListAgents")
    @RequestMapping(value="/Admin/ListAgents",method=RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Agent> ListAgents() {
		return adminMetier.ListAgents();
	}
	@WebMethod(operationName = "FindAgent")
    @RequestMapping(value="/Admin/FindAgent/{code}",method=RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public Agent FindAgent(@PathVariable("code")@WebParam(name = "codeAgent")Long code) {
		return adminMetier.FindAgent(code);
	}

	@WebMethod(operationName = "addAgent")
    @RequestMapping(value="/Admin/addAgent/{code}",method=RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public Agent CreateAgent(@RequestBody @WebParam(name = "Agent")Agent t, @RequestBody @PathVariable("code")@WebParam(name = "codeAgence") Long code) {
		return adminMetier.CreateAgent(t, code);
	}
	@WebMethod(operationName = "updateAgent")
    @RequestMapping(value="/Admin/updateAgent/{code}",method=RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void UpdateAgent(@RequestBody @WebParam(name = "Agent") Agent t, @RequestBody @PathVariable("code")@WebParam(name = "nameAgence") Long code) {
		adminMetier.UpdateAgent(t,code);
	}
	@WebMethod(operationName = "deleteAgent")
    @RequestMapping(value="/Admin/deleteAgent/{code}",method=RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void DeleteAgent(@PathVariable("code") @WebParam(name = "code") Long code) {
		adminMetier.DeleteAgent(code);
	}
	@WebMethod(operationName = "ListParameters")
    @RequestMapping(value="/Admin/ListParameters",method=RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT') or hasRole('AGENT')")
	public Parameters ListParameters() {
		return adminMetier.ListParameters();
	}
	@WebMethod(operationName = "SetParameters")
    @RequestMapping(value="/Admin/SetParameters",method=RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void SetParameters(@RequestBody@WebParam(name = "Parameters") Parameters p) {
		adminMetier.SetParameters(p);
	}
	@WebMethod(operationName = "SetLibelles")
    @RequestMapping(value="/Admin/SetLibelles",method=RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void SetLibelles(@RequestBody @WebParam(name = "Libelles") Libelles l) {
		adminMetier.SetLibelles(l);
	}
	@WebMethod(operationName = "ListLibelles")
	@RequestMapping(value="/Admin/ListLibelles",method=RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT') or hasRole('AGENT')")
	public Libelles ListLibelles() {
		return adminMetier.ListLibelles();
	}
	@WebMethod(operationName = "addAgence")
    @RequestMapping(value="/Admin/addAgence/{code}",method=RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public Agence CreateAgence(@RequestBody @WebParam(name = "Agent")Agence a, @RequestBody @PathVariable("code")@WebParam(name = "codeAdmin")  Long code) {
		return adminMetier.CreateAgence(a, code);
	}
	@WebMethod(operationName = "updateAgence")
    @RequestMapping(value="/Admin/updateAgence",method=RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void UpdateAgence(@RequestBody @WebParam(name = "Agence") Agence a) {
		adminMetier.UpdateAgence(a);
	}
	@WebMethod(operationName = "deleteAgence")
    @RequestMapping(value="/Admin/deleteAgence/{code}",method=RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public void DeleteAgence(@PathVariable("code") @WebParam(name = "code") Long code) {
		adminMetier.DeleteAgence(code);
	}
	@WebMethod(operationName = "getAgences")
    @RequestMapping(value="/Admin/getAgences",method=RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Agence> ListAgences() {
		return adminMetier.ListAgences();
	}
	@WebMethod(operationName = "getComptes")
    @RequestMapping(value="/Admin/getComptes",method=RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Compte> getComptes() {
		return adminMetier.getComptes();
	}
	

}
