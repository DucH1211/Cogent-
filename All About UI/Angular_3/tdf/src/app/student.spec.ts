import { Student } from './student';

describe('Person', () => {
  it('should create an instance', () => {
    expect(new Student()).toBeTruthy();
  });
});
