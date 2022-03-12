import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/models/project/project';

@Component({
  selector: 'project-table',
  templateUrl: './project-table.component.html',
  styleUrls: ['./project-table.component.scss'],
})
export class ProjectTableComponent implements OnInit {
  projectData: Project[];
  displayedColumns: string[];

  constructor() {
    this.projectData = [
      {
        name: 'Project 1',
        description: 'This is project 1',
        contributors: ['Tony', 'Ant'],
      },
      {
        name: 'Project 2',
        description: 'This is project 2',
        contributors: ['Tony'],
      },
      {
        name: 'Project 3',
        description: 'This is project 3',
        contributors: ['Tony', 'Ant'],
      },
    ];
    this.displayedColumns = ['name', 'description', 'contributors'];
  }

  ngOnInit(): void {}
}
