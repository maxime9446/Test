"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.BowlingScore = void 0;
class BowlingScore {
    constructor(frames) {
        this.frames = frames;
    }
    calculateTotalScore() {
        let totalScore = 0;
        for (let i = 0; i < this.frames.length; i++) {
            totalScore += this.frames[i];
        }
        return totalScore;
    }
    calculateTotalScoreWithSpare() {
        let totalScore = 0;
        for (let i = 0; i < this.frames.length; i++) {
            totalScore += this.frames[i];
            if (i < this.frames.length - 1 && this.frames[i] + this.frames[i + 1] === 10) {
                totalScore += this.frames[i + 2];
            }
        }
        return totalScore;
    }
    calculateTotalScoreWithStrike() {
        let totalScore = 0;
        for (let i = 0; i < this.frames.length; i++) {
            totalScore += this.frames[i];
            if (i < this.frames.length - 1 && this.frames[i] === 10) {
                totalScore += this.frames[i + 1];
            }
        }
        return totalScore;
    }
    calculateTotalScoreWithSpareAndStrike() {
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
exports.BowlingScore = BowlingScore;
//# sourceMappingURL=bowling.score.js.map