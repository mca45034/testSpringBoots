package com.rays.ctl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.EmployeDTO;
import com.rays.form.EmployeForm;
import com.rays.service.EmployeService;

@RestController
@RequestMapping(value = "Emp")
public class EmployeCtl extends BaseCtl {

	@Autowired
	public EmployeService employeService;

	@GetMapping
	public String disp() {
		return "i am @GetMapping employes...!!!!!!!!!!!!!!!";
	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {
		ORSResponse res = new ORSResponse();
		EmployeDTO dto = employeService.findById(id);
		res.addData(dto);
		return res;
	}

	@GetMapping("delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {
		ORSResponse res = new ORSResponse();
		for (long id : ids) {
			employeService.delete(id);

		}
		res.addMessage("data deleted successfully");
		return res;
	}

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid EmployeForm form, BindingResult bindingResult) {
		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}
		EmployeDTO dto = (EmployeDTO) form.getDto();

		if (dto.getId() != null && dto.getId() > 0) {
			employeService.update(dto);
			res.addData(dto.getId());
			res.addMessage("Data Updated Successfully..!!");
		} else {
			long pk = employeService.add(dto);
			res.addData(pk);
			res.addMessage("Data added Successfully..!!");
		}
		return res;

	}

	@PostMapping("search")
	public ORSResponse search(@RequestBody EmployeForm from) {
		ORSResponse res = new ORSResponse();

		EmployeDTO dto = new EmployeDTO();
		List list = employeService.search(dto);
		if (list.size() == 0) {
			res.addMessage("result not founf..!!!");
		} else {
			res.addData(list);
		}
		return res;
	}

}
