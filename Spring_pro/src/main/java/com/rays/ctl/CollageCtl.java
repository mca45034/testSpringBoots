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
import com.rays.dto.CollageDTO;
import com.rays.form.CollageForm;
import com.rays.service.CollageService;

@RestController
@RequestMapping(value = "Collage")
public class CollageCtl extends BaseCtl {
	@Autowired
	public CollageService collageService;

	@GetMapping
	public String disp() {
		return "i am @GetMapping collage";
	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {
		ORSResponse res = new ORSResponse();
		CollageDTO dto = collageService.findById(id);
		res.addData(dto);
		return res;

	}

	@GetMapping("delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {
		ORSResponse res = new ORSResponse();
		for (long id : ids) {
			collageService.delete(id);
		}
		res.addMessage("Data deleted successfully.");
		return res;
	}

	@PostMapping("search")
	public ORSResponse search(@RequestBody CollageForm form) {
		ORSResponse res = new ORSResponse();
		CollageDTO dto=new CollageDTO();
		List list=collageService.search(dto);
		
		if(list.size()==0) {
			res.addMessage("Result not found...!!!!!");
		}else {
			res.addData(list);
		}
		return res;
	}

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid CollageForm form, BindingResult bindingResult) {
		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}
		CollageDTO dto = (CollageDTO) form.getDto();

		if (dto.getId() != null && dto.getId() > 0) {
			collageService.update(dto);
			res.addData(dto.getId());
			res.addMessage("Data Updated Successfully..!!");
		} else {
			long pk = collageService.add(dto);
			res.addData(pk);
			res.addMessage("Data added Successfully..!!");
		}
		return res;

	}
}
