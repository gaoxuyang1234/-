$(function(){
	ajaxLine({arr:[4,5,6,7,8,9,10,11,12]},"main1");
	let ars=[];
	for(let i=13;i<=40;i++){ars.push(i)};
	ajaxLine({arr:ars},"main2");
})

function ajaxLine(obj,select){
	var myChart = echarts.init(document.getElementById(select));
	$.post("/sta/lineList",obj)
	 .then(function(data){
		 console.log(data);
		 let option=funoption();
		 $.each(data.data["list"],function(index,obj){
			 let{dId,dName,december,feburary,january,july,june,march,may,november,october,september,april,august,}=obj;
			 option.series.push(
					 {      
                            name: dName,
				            type: 'line',
				            data:[january,feburary,march,april,may,june,july,august,september,october,november,december],
				            markPoint: {
				                data: [
				                    { type: 'max'}, 
				                    { type: 'min'},
				                ]
				            },
				            
				        } 
					 )
			 option.legend.data.push(dName)
		 })
		 myChart.setOption(option);
	 })
	
}


function funoption(){
 const	option = {
			    title: {text: ''},
			    tooltip: {trigger: 'axis'},
			  //右上角工具条
		        toolbox: {
		            show: true,
		            feature: {
		                mark: { show: true },//目前还不知道有啥用
		                dataView: { show: true, readOnly: true },//数据视图
		                magicType: { show: true, type: ['line', 'bar'] },//折线与柱状的切换
		                restore: { show: true },//重置
		                saveAsImage: { show: true }//保存为图片
		            }
		        },
			    legend: {data:[]},
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    toolbox: {feature: {saveAsImage: {}}},
			    xAxis: {
			        type: 'category',
			        boundarGap:false,
			        axisLabel:{
			        	rotate:30,
			        	interval:0
			        },
			        boundaryGap: false,
			        data: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月',"十二月"]
			    },
			    yAxis: {type: 'value',boundarGap:false,axisLine:{
			    	lineStyle:{
			    		//color:"green"
			    	}
			    }},
			    series: []};
	  return option;        
}


