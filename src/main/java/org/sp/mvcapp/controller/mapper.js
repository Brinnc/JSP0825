{
	"controller":{
		"/blood.do": "org.sp.mvcapp.controller.BloodController",
		"/movie.do": "org.sp.mvcapp.controller.MovieController",
		
		"/board/list.do": "org.sp.mvcapp.controller.ListController",
		"/board/regist.do": "org.sp.mvcapp.controller.RegistController",
		"/board/content.do": "org.sp.mvcapp.controller.ContentController",
		"/board/delete.do": "org.sp.mvcapp.controller.DeleteController",
		"/board/edit.do": "org.sp.mvcapp.controller.EditController"
		
	},
	
	"view":{
		"bloodView": "/blood/result.jsp",
		"movieView": "/movie/result.jsp",
		
		"board/listView": "/board/list.jsp",
		"board/registView": "/board/list.do", 
		"board/contentView": "/board/content.jsp",
		"board/deleteView": "/board/list.do",
		"board/editView": "/board/content.jsp"
		
	}
}