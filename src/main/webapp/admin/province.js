var defaults = {
    s1: 'provice',
    s2: 'city',
    s3: 'county',
    v1: null,
    v2: null,
    v3: null
};
var prov_01="<option value='1'>请选择</option>";
var $form;
var form;
var $;
layui.define(['jquery', 'form'], function () {
    $ = layui.jquery;
    form = layui.form;
    $form = $('form');
    treeSelect(defaults);
});
function checkedSelect(provice,city,county){
	var city_01="";	
	var county_01="";
	for(var i in threeSelectData){
		
		if(i!=provice){
			prov_01=prov_01+"<option>"+i+"</option>";
		}else{
			prov_01=prov_01+"<option selected='selected'>"+i+"</option>";
			for(var j in threeSelectData[i]['items']){
				if(j!=city){
					city_01=city_01+"<option>"+j+"</option>";
				}else{
					city_01=city_01+"<option selected='selected'>"+j+"</option>";
					for(var n in threeSelectData[i]['items'][j]['items']){
						county_01= n!=county?county_01+"<option>"+n+"</option>":county_01+"<option selected='selected'>"+n+"</option>";
					}
				}
			}
		}
	}
	$("#provice").html(prov_01);
	$("#city").html(city_01);
	$("#county").html(county_01);
	
}

function treeSelect(config) {
    config.v1 = config.v1 ? config.v1 : 110000;
    config.v2 = config.v2 ? config.v2 : 110100;
    config.v3 = config.v3 ? config.v3 : 110101;
  /*  $.each(threeSelectData, function (k, v) {
//    	alert('select[name=' + config.s1 + ']'+"k="+ k+"----v.val="+ v.val+"----config.v1="+ config.v1);
        appendOptionTo($form.find('select[name=' + config.s1 + ']'), k, v.val, config.v1);
    	 appendOptionTo($form.find('select[name=' + config.s1 + ']'), k, k, config.v1);
    });*/
    form.render();
    //cityEvent(config);
    //areaEvent(config);
    form.on('select(' + config.s1 + ')', function (data) {
        cityEvent(data);
        form.on('select(' + config.s2 + ')', function (data) {
            areaEvent(data);
        });
    });

    function cityEvent(data) {
        $form.find('select[name=' + config.s2 + ']').html("");
        config.v1 = data.value ? data.value : config.v1;
        $.each(threeSelectData, function (k, v) {
        	if(k == config.v1){
            //if (v.val == config.v1) {
                if (v.items) {
                    $.each(v.items, function (kt, vt) {
                       /* appendOptionTo($form.find('select[name=' + config.s2 + ']'), kt, vt.val, config.v2);*/
                    	appendOptionTo($form.find('select[name=' + config.s2 + ']'), kt, kt, config.v2);
                    });
                }
            }
        });
        form.render();
        config.v2 = $('select[name=' + config.s2 + ']').val();
        areaEvent(config);
    }
    function areaEvent(data) {
        $form.find('select[name=' + config.s3 + ']').html("");
        config.v2 = data.value ? data.value : config.v2;
        $.each(threeSelectData, function (k, v) {
            if (k == config.v1) {
                if (v.items) {
                    $.each(v.items, function (kt, vt) {
                        if (kt == config.v2) {
                            $.each(vt.items, function (ka, va) {
                                /*appendOptionTo($form.find('select[name=' + config.s3 + ']'), ka, va, config.v3);*/
                            	appendOptionTo($form.find('select[name=' + config.s3 + ']'), ka, ka, config.v3);
                            });
                        }
                    });
                }
            }
        });
        form.render();
        form.on('select(' + config.s3 + ')', function (data) { });
        
    }
    function appendOptionTo($o, k, v, d) {
        var $opt = $("<option>").text(k).val(v);
        if (v == d) { $opt.attr("selected", "selected") }
        $opt.appendTo($o);
    }
}
