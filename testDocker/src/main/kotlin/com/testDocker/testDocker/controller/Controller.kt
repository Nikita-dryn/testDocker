package com.testDocker.testDocker.controller
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1")
class Controller
{
    val mapOfObjects = mutableMapOf<Int,String>()

    @GetMapping("/")
    fun getAll()=mapOfObjects


    @DeleteMapping("/delete/{id}")
    fun deleteById(@PathVariable id: Int):ResponseEntity<Void>
    {
        if(mapOfObjects.contains(id))
        {
            mapOfObjects.remove(id)
        } else {return ResponseEntity.status(404).build()}
        return ResponseEntity.ok().build()
    }

    @PostMapping("/create/{id}/{name}")
    fun createObject(@PathVariable id:Int, @PathVariable name: String):ResponseEntity<Void>
    {
        if(!mapOfObjects.containsKey(id) && !mapOfObjects.containsValue(name))
        {
            mapOfObjects[id] = name
        } else{return ResponseEntity.badRequest().build()}

        return ResponseEntity.ok().build()
    }

    @PutMapping("/update/{id}/{name}")
    fun updateObject(@PathVariable id:Int,@PathVariable name:String):ResponseEntity<Void>
    {
        if(mapOfObjects.containsKey(id))
        {
            mapOfObjects.replace(id, name)
        } else {return ResponseEntity.notFound().build()}
        return ResponseEntity.ok().build()
    }
}