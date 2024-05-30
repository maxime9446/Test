export class BowlingScore {
    constructor(private readonly frames: number[]) {}
  
    calculateTotalScore(): number {
      let totalScore = 0;
      for (let i = 0; i < this.frames.length; i++) {
        totalScore += this.frames[i];
      }
      return totalScore;
    }

    calculateTotalScoreWithSpare(): number {
      let totalScore = 0;
      for (let i = 0; i < this.frames.length; i++) {
        totalScore += this.frames[i];
        if (i < this.frames.length - 1 && this.frames[i] + this.frames[i + 1] === 10) {
          totalScore += this.frames[i + 2];
        }
      }
      return totalScore;
    }

    calculateTotalScoreWithStrike(): number {
      let totalScore = 0;
      for (let i = 0; i < this.frames.length; i++) {
        totalScore += this.frames[i];
        if (i < this.frames.length - 1 && this.frames[i] === 10) {
          totalScore += this.frames[i + 1];
        }
      }
      return totalScore;
    }

    calculateTotalScoreWithSpareAndStrike(): number {
      let totalScore = 0;
      for (let i = 0; i < this.frames.length; i++) {
        totalScore += this.frames[i];
        if (i < this.frames.length - 1 && this.frames[i] + this.frames[i + 1] === 10) {
          totalScore += this.frames[i + 2];
        }
        if (i < this.frames.length - 1 && this.frames[i] === 10) {
          totalScore += this.frames[i + 1];
        }
      }
      return totalScore;
    }
  
  }
  